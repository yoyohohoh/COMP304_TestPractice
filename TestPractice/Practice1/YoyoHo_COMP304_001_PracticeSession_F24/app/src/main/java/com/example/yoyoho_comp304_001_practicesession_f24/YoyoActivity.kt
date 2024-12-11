package com.example.yoyoho_comp304_001_practicesession_f24

import android.os.Bundle
import android.provider.Settings.Global.getString
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.yoyoho_comp304_001_practicesession_f24.ui.theme.YoyoHo_COMP304_001_PracticeSession_F24Theme
import com.example.yoyoho_comp304_001_practicesession_f24.views.SulleyActivityContent

class YoyoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YoyoHo_COMP304_001_PracticeSession_F24Theme {
                    MyNotesApp()
            }
        }
    }
}

@Composable
fun MyNotesApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "yoyoActivity") {
        composable("yoyoActivity") {
            YoyoActivityContent {
                navController.navigate("smithActivity")
            }
        }
        composable("smithActivity") {
            SulleyActivityContent()
        }
    }
}

@Composable
fun YoyoActivityContent(onNavigate: () -> Unit) {HomeScreen
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //Add logo
        Image(
            // Place a logo image (e.g., logo.png) and any other icons in the res/drawable directory.
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier.size(128.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigate) {
            //Update the res/values/strings.xml for any string resources
            val context = LocalContext.current
            // Retrieve the string resource
            val logoName = remember { context.getString(R.string.logo_name) }
            Text(text = "Go to MyNotes")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MyNotesAppPreview() {
    YoyoHo_COMP304_001_PracticeSession_F24Theme {
        MyNotesApp()
    }
}