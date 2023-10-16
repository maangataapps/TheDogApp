package com.maangataapps.thedogapp.presentation.breedsscreen.view

import androidx.annotation.DrawableRes
import com.maangataapps.thedogapp.R

sealed class ChangeLayoutType(
    open val id: Int,
    @DrawableRes open val icon: Int,
    open val onClick: (() -> Unit)? = null,
) {

    data class ChangeToList(
        override val id: Int = LayoutId.List.ordinal,
        override val icon: Int = R.drawable.list_icon,
        override val onClick: (() -> Unit)? = null,
    ): ChangeLayoutType(id, icon, onClick)

    data class ChangeToGrid(
        override val id: Int = LayoutId.Grid.ordinal,
        override val icon: Int = R.drawable.grid_icon,
        override val onClick: (() -> Unit)? = null,
    ): ChangeLayoutType(id, icon, onClick)
}

enum class LayoutId {
    List, Grid
}

