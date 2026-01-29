package com.gcorp.multirecherche3d.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gcorp.multirecherche3d.domain.model.ModelItem
import com.gcorp.multirecherche3d.ui.theme.MultiRecherche3DTheme

@Composable
fun MainApp() {
    val viewModel: MainAppViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Surface {
        Scaffold(
            modifier = Modifier.padding(20.dp)
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var queryText by remember { mutableStateOf("poulpe") }

                OutlinedTextField(
                    value = queryText,
                    onValueChange = { queryText = it }
                )

                Button(
                    onClick = { viewModel.multiSearch(queryText) }
                ) {
                    Text(text = "OK")
                }

                LazyColumn {
                    items(uiState.searchResults) {
                        ModelItem(item = it)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun ModelItem(
    modifier: Modifier = Modifier,
    item: ModelItem
) {
    Card(
        modifier = modifier.padding(4.dp)
    ) {
        Text(item.title)

        Spacer(modifier = Modifier.height(8.dp))

        Text(item.url.toString())

        Spacer(modifier = Modifier.height(2.dp))

        Text("Likes : ${item.likeCount}")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MultiRecherche3DTheme {
        MainApp()
    }
}