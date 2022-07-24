package com.barros.composefunctions.ui.screens.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.barros.composefunctions.R
import com.barros.composefunctions.domain.model.Theme
import com.barros.composefunctions.ui.screens.NavTarget.SwipeButton
import com.barros.composefunctions.ui.theme.Shapes

@Composable
fun HomeScreen(
    navHostController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeContent(
        onSelectTheme = { viewModel.onThemeChanged(it) },
        onClickSwipeButton = { navHostController.navigate(SwipeButton.route) }
    )
}

@Composable
fun HomeContent(
    onSelectTheme: (Theme) -> Unit,
    onClickSwipeButton: () -> Unit
) {
    var showMenu by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                actions = {
                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = null
                        )
                    }
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {
                        DropdownMenuItem(
                            onClick = {
                                onSelectTheme(Theme.Light)
                                showMenu = false
                            }
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.LightMode,
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.padding(8.dp))
                                Text(stringResource(R.string.light_mode))
                            }
                        }
                        DropdownMenuItem(
                            onClick = {
                                onSelectTheme(Theme.Dark)
                                showMenu = false
                            }
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.DarkMode,
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.padding(8.dp))
                                Text(stringResource(R.string.dark_mode))
                            }
                        }
                    }
                }
            )
        }
    ) {
        ButtonCard(
            stringResource = R.string.swipe_button,
            onClickButton = { onClickSwipeButton() }
        )
    }
}

@Composable
fun ButtonCard(
    stringResource: Int,
    onClickButton: () -> Unit
) {
    Button(
        modifier = Modifier
            .padding(vertical = 4.dp, horizontal = 16.dp)
            .fillMaxWidth(),
        shape = Shapes.large,
        onClick = onClickButton
    ) {
        Text(stringResource(stringResource))
    }
}