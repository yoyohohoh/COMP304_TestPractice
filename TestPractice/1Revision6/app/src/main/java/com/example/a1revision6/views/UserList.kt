package com.example.a1revision6.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a1revision6.R
import com.example.a1revision6.data.User
import com.example.a1revision6.viewmodel.UsersViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun UserList(modifier :Modifier) {
//    // for dependency Injection
//    val usersViewModel: UsersViewModel = koinViewModel()
//    val users = usersViewModel.getUsers()
//    LazyColumn(
//        modifier = Modifier
//    ) {
//        items(users) { user ->
//            UserListItems(user)
//        }
//    }
//}
//
//@Composable
//fun UserListItems(user: User) {
//    Card(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxSize()
//        )
//        {
//            Column(
//                modifier = Modifier
//                    .weight(1f)
//            )
//            {
//                Text(
//                    text = "Owner Name: ${user.name}",
//                    modifier = Modifier
//                        .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp),
//                    textAlign = TextAlign.Start,
//                )
//                Text(
//                    text = "Pet Name: ${user.petName}",
//                    modifier = Modifier
//                        .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
//                )
//            }
//
//            Image(
//                painter = painterResource(id = R.drawable.logo),
//                contentDescription = "App Logo",
//                modifier = Modifier
//                    .size(100.dp)
//                    .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun UserListPreview() {
//    val mockUsers = listOf(User(0,"Yohanna", "Yoyo"))
//    LazyColumn {
//        items(mockUsers) { user ->
//            UserListItems(user)
//        }
//    }
}
