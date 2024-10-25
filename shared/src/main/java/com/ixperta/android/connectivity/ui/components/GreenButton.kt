package com.ixperta.android.connectivity.ui.components



import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ixperta.android.connectivity.ui.styles.AppColors

@Composable
fun GreenButton(onClick: () -> Unit, title: String, maxWidth: Boolean = true, enabled: Boolean = true) {
    var modifier = Modifier.fillMaxWidth()
    if(!maxWidth){
        modifier=  Modifier.padding()
    }
    Row(modifier =  modifier) {
        OutlinedButton(
            enabled = enabled ,
            modifier = modifier,
            onClick = onClick,
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(backgroundColor = AppColors.skodaGreenColor)
        ) { Text(title, modifier = Modifier.padding(horizontal = 32.dp, vertical = 5.dp),color = AppColors.carItemBackground, fontWeight = FontWeight.Bold, fontSize = 16.sp) }
    }
}