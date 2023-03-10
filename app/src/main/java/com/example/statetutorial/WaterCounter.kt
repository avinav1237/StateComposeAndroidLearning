import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
    private fun WaterCounter(modifier: Modifier) {
        val count = 0
        Text(
            text = "You've had $count glasses.",
            modifier = modifier.padding(16.dp)
        )
    }