package common

sealed class UIComponent {
    data object Toast : UIComponent()
    data class Dialog(val title: String, val description: String) : UIComponent()
    data class SnackBar(val message: String, val actionLabel: String) : UIComponent()
}
