import tornadofx.*
import java.awt.Event.HOME

class CalcView: View(){
    override val root = vbox {
        label("Calculator")
        textfield {  }
        hbox {
            button("1").setOnAction {
                println("Button 1 Pressed")
            }
            button("2").setOnAction {
                println("Button 2 Pressed")
            }
            button("3").setOnAction {
                println("Button 3 Pressed")
            }
            button("+").setOnAction {
                println("Button + Pressed")
            }
        }
        hbox {
            button("4").setOnAction {
                println("Button 4 Pressed")
            }
            button("5").setOnAction {
                println("Button 5 Pressed")
            }
            button("6").setOnAction {
                println("Button 6 Pressed")
            }
            button("-").setOnAction {
                println("Button - Pressed")
            }
        }
        hbox {
            button("7").setOnAction {
                println("Button 7 Pressed")
            }
            button("8").setOnAction {
                println("Button 8 Pressed")
            }
            button("9").setOnAction {
                println("Button 9 Pressed")
            }
            button("*").setOnAction {
                println("Button * Pressed")
            }
        }
        hbox {
            button("Clear").setOnAction {
                println("Button Clear Pressed")
            }
            button("0").setOnAction {
                println("Button 0  Pressed")
            }
            button("/").setOnAction {
                println("Button / Pressed")
            }

        }

    }
}