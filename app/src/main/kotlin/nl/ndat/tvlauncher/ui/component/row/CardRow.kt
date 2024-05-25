package nl.ndat.tvlauncher.ui.component.row

import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusRestorer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CardRow(
	modifier: Modifier = Modifier,
	title: String? = null,
	content: LazyListScope.() -> Unit,
) = Column(
	modifier = modifier
		.focusGroup()
		.focusRestorer()
) {
	CompositionLocalProvider(
		LocalRippleConfiguration provides null,
	) {
		if (title != null) {
			Text(
				text = title,
				fontSize = 18.sp,
				modifier = Modifier.padding(
					vertical = 4.dp,
					horizontal = 48.dp,
				)
			)
		}

		LazyRow(
			modifier = Modifier.fillMaxWidth(),
			contentPadding = PaddingValues(
				vertical = 16.dp,
				horizontal = 48.dp,
			),
			horizontalArrangement = Arrangement.spacedBy(14.dp),
		) {
			content()
		}
	}
}
