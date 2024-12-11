package com.example.a1revision6.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.a1revision6.R
import com.example.a1revision6.data.Cat
import com.example.a1revision6.viewmodel.UsersViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun CatList(modifier: Modifier) {
    val usersViewModel: UsersViewModel = koinViewModel()
    val usersUIState by usersViewModel.usersUIState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .padding(0.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visible = usersUIState.isLoading
        ) {
            CircularProgressIndicator()
        }

        AnimatedVisibility(
            visible = usersUIState.users.isNotEmpty()
        ) {
            LazyColumn {
                items(usersUIState.users) { user ->
                    CatListItem(cat = user)
                }
            }
        }
        AnimatedVisibility(
            visible = usersUIState.error != null
        ) {
            Text(text = usersUIState.error ?: "")
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CatListItem(cat: Cat) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp)
    ) {


            Column(
                modifier = Modifier
                    .fillMaxSize()
            )
            {
                Text(
                    text = "Cat ID: ${cat.id}",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp),
                )


                AsyncImage(
                    model = "https://cataas.com/cat/${cat.id}",
                    contentDescription = "Cute cat",
                    modifier = Modifier
                        .size(400.dp)
                        .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 16.dp)
                )
            }

    }
}
