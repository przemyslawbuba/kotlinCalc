import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.Alert
import javafx.scene.control.Alert.AlertType
import javafx.scene.paint.Color
import tornadofx.*


class CalcView: View(){
    val input = SimpleStringProperty()
    val calculations: Calculations by inject()
    var alert = Alert(AlertType.NONE)

    override val root = vbox {
        label("Calculator")
        input.value = ""
        var result : String
        fieldset {
                textfield(input)
            }

        hbox {
            button("1").setOnAction {
                println("Button 1 Pressed")
                input.value = input.value + "1"
            }
            button("2").setOnAction {
                println("Button 2 Pressed")
                input.value = input.value + "2"
            }
            button("3").setOnAction {
                println("Button 3 Pressed")
                input.value = input.value + "3"
            }
            button("+").setOnAction {
                println("Button + Pressed")
                input.value = input.value + "+"
            }
        }
        hbox {
            button("4").setOnAction {
                println("Button 4 Pressed")
                input.value = input.value + "4"
            }
            button("5").setOnAction {
                println("Button 5 Pressed")
                input.value = input.value + "5"
            }
            button("6").setOnAction {
                println("Button 6 Pressed")
                input.value = input.value + "6"
            }
            button("-").setOnAction {
                println("Button - Pressed")
                input.value = input.value + "-"
            }
        }
        hbox {
            button("7").setOnAction {
                println("Button 7 Pressed")
                input.value = input.value + "7"
            }
            button("8").setOnAction {
                println("Button 8 Pressed")
                input.value = input.value + "8"
            }
            button("9").setOnAction {
                println("Button 9 Pressed")
                input.value = input.value + "9"
            }
            button("*").setOnAction {
                println("Button * Pressed")
                input.value = input.value + "*"
            }
        }
        hbox {
            button("=" ).setOnAction {
                println("Button = Pressed")
                result = ""
                result = calculations.getResult(input.value)
                alert.setAlertType(AlertType.INFORMATION)
                if((result == "Invalid character") or (result == "Invalid first character")
                    or (result == "Invalid last character") or (result == "Incorrect operation")){
                    alert.setContentText(result)
                    alert.show()
                }else{
                        alert.setContentText(input.value + "=" + result)
                        alert.show()
                        input.value = ""
                }
            }
            button("0").setOnAction {
                println("Button 0  Pressed")
                input.value = input.value + "0"
            }
            button("/").setOnAction {
                println("Button / Pressed")
                input.value = input.value + "/"
            }
            button("Clear").setOnAction {
                println("Button Clear Pressed")
                input.value = ""
            }
        }
    }
}