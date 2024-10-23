package com.ixperta.android.connectivity.configuration.payment

import com.google.android.gms.wallet.Wallet.WalletOptions
import com.google.android.gms.wallet.WalletConstants
import com.ixperta.android.connectivity.application.payment.PayConfig
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.math.BigDecimal
import java.math.RoundingMode

class DefaultPayConfig : PayConfig {
    override fun createIsReadyToPayRequest(): JSONObject? {
        return try {
            createBaseRequest()
                .put("allowedPaymentMethods", JSONArray().put(createBaseCardPaymentMethod()))
        } catch (e: JSONException) {
            null
        }
    }


    override fun createWalletOption(): WalletOptions {
        return WalletOptions.Builder().setEnvironment(WalletConstants.ENVIRONMENT_TEST).build()
    }

    override fun createPaymentDataRequest(priceCents: Long): JSONObject {
        return createBaseRequest()
            .put("allowedPaymentMethods", createAllowedPaymentMethods())
            .put("transactionInfo", getTransactionInfo(priceCents.centsToString()))
            .put("merchantInfo", createMerchantInfo())
            .put("shippingAddressRequired", true)
            .put(
                "shippingAddressParameters", JSONObject()
                    .put("phoneNumberRequired", false)
                    .put("allowedCountryCodes", JSONArray(listOf("US", "GB")))
            )
    }


    private fun createBaseRequest(): JSONObject {
        return JSONObject()
            .put("apiVersion", 2)
            .put("apiVersionMinor", 0)

    }


    private fun createGatewayTokenizationSpecification(): JSONObject {
        return JSONObject().apply {
            put("type", "PAYMENT_GATEWAY")
            put(
                "parameters", JSONObject(
                    mapOf(
                        "gateway" to "example",
                        "gatewayMerchantId" to "exampleGatewayMerchantId"
                    )
                )
            )
        }
    }

    private fun createMerchantInfo(): JSONObject {
        return JSONObject().put("merchantName", "Example Merchant")
    }

    private fun createAllowedPaymentMethods(): JSONArray {
        return JSONArray().put(createCardPaymentMethod())
    }


    private fun getTransactionInfo(price: String): JSONObject =
        JSONObject()
            .put("totalPrice", price)
            .put("totalPriceStatus", "FINAL")
            .put("countryCode", "US")
            .put("currencyCode", "USD")

    private fun createCardPaymentMethod(): JSONObject {
        return createBaseCardPaymentMethod()
            .put("tokenizationSpecification", createGatewayTokenizationSpecification())
    }

    private fun createBaseCardPaymentMethod(): JSONObject =
        JSONObject()
            .put("type", "CARD")
            .put(
                "parameters", JSONObject()
                    .put("allowedAuthMethods", createAllowedCardAuthMethods())
                    .put("allowedCardNetworks", crateAllowedCardNetworks())
                    .put("billingAddressRequired", true)
                    .put(
                        "billingAddressParameters", JSONObject()
                            .put("format", "FULL")
                    )
            )


    private fun crateAllowedCardNetworks(): JSONArray {
        return JSONArray(
            listOf(
                "AMEX",
                "DISCOVER",
                "INTERAC",
                "JCB",
                "MASTERCARD",
                "VISA"
            )
        )
    }

    private fun createAllowedCardAuthMethods(): JSONArray {
        return JSONArray(
            listOf(
                "PAN_ONLY",
                "CRYPTOGRAM_3DS"
            )
        )
    }
}

fun Long.centsToString() = BigDecimal(this)
    .divide(BigDecimal(100))
    .setScale(2, RoundingMode.HALF_EVEN)
    .toString()