import tornadofx.*

class MyApp: App(CalcView::class) {
    fun main(args: Array<String>) {
        launch<MyApp>(args)
    }
}