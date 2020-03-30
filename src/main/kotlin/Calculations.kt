import tornadofx.Controller
import java.lang.Exception

class Calculations: Controller() {
    fun getResult(inputValue: String) : String {
        var operation : String
        operation = inputValue
        var result : String
        var i : Int
        result = "?"
        var match : Boolean;
        val tmpC : String
        var tmpResult : String
        val allSigns =
            arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "/", "*")
        val allNumber =
            arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        val allOperators =
            arrayOf("+", "-", "/", "*")

        //Sprawdzanie czy wszsytkie znaki są poprawne
        for(c in operation) {
            match = false;
            for(cc in allSigns){
                if(cc == c.toString()){
                    match = true
                }
            }
            if (!match){
                result = "Invalid character"
                return result
            }
        }

        //Sprawdzanie czy na początku i na końcu działania jest liczba
        if((operation.first() == '+') or (operation.first() == '-') or
                (operation.first() == '/') or (operation.first() == '*')){
            result = "Invalid first character"
            return result
        } else if((operation.last() == '+') or (operation.last() == '-') or
            (operation.last() == '/') or (operation.last() == '*')) {
            result = "Invalid last character"
            return result
        }

        //Sprawdzanie czy operatory nie występują obok siebie
        i = 0
        for(c in operation) {
            i++
            if ((c == '+') or (c == '-') or (c == '/') or (c == '*')) {
                if ((operation[i] == '+') or (operation[i] == '-') or (operation[i] == '/') or (operation[i] == '*')) {
                    result = "Incorrect operation"
                    return result
                }
            }
        }


        //Docelowe obliczenia
        var index : Int
        var numeric = true
        var tmpString : String
        var firstNumber : String
        var firstIndex  : Int
        var secondNumber : String
        var secondIndex  : Int
        tmpResult = ""
        firstNumber = ""
        secondNumber = ""
        firstIndex = 0
        secondIndex = 0


        //Mnozenie
        while(operation.contains("*")) {
            index = operation.indexOf('*')
            firstIndex = index - 1
            secondIndex = index + 1
            firstNumber = ""
            secondNumber = ""
            while ((operation[firstIndex] != '+') and (operation[firstIndex] != '-') and (operation[firstIndex] != '/') and (operation[firstIndex] != '*')) {
                firstNumber = operation[firstIndex] + firstNumber
                if (firstIndex == 0) {
                    break
                } else
                    firstIndex--
            }
            while ((operation[secondIndex] != '+') and (operation[secondIndex] != '-') and (operation[secondIndex] != '/') and (operation[secondIndex] != '*')) {
                secondNumber += operation[secondIndex]
                if (secondIndex == operation.length - 1) {
                    break
                } else
                    secondIndex++
            }
            tmpResult = (firstNumber.toInt() * secondNumber.toInt()).toString()
            operation = operation.replace(firstNumber + "*" + secondNumber, tmpResult)

        }


        //Dzielenie
        while(operation.contains("/")){
            index = operation.indexOf('/')
            firstIndex = index - 1
            secondIndex = index + 1
            firstNumber = ""
            secondNumber = ""
            while ((operation[firstIndex] != '+') and (operation[firstIndex] != '-') and (operation[firstIndex] != '/') and (operation[firstIndex] != '*')) {
                firstNumber = operation[firstIndex] + firstNumber
                if (firstIndex == 0) {
                    break
                } else
                    firstIndex--
            }
            while ((operation[secondIndex] != '+') and (operation[secondIndex] != '-') and (operation[secondIndex] != '/') and (operation[secondIndex] != '*')) {
                secondNumber += operation[secondIndex]
                if (secondIndex == operation.length - 1) {
                    break
                } else
                    secondIndex++
            }
            tmpResult = (firstNumber.toFloat() / secondNumber.toFloat()).toString()
            operation = operation.replace(firstNumber + "/" + secondNumber, tmpResult)
        }


        //Dodawanie
        while(operation.contains("+")){
                index = operation.indexOf('+')
                firstIndex = index - 1
                secondIndex = index + 1
                firstNumber = ""
                secondNumber = ""
                while ((operation[firstIndex] != '+') and (operation[firstIndex] != '-') and (operation[firstIndex] != '/') and (operation[firstIndex] != '*')) {
                    firstNumber = operation[firstIndex] + firstNumber
                    if (firstIndex == 0) {
                        break
                    } else
                        firstIndex--
                }
                while ((operation[secondIndex] != '+') and (operation[secondIndex] != '-') and (operation[secondIndex] != '/') and (operation[secondIndex] != '*')) {
                    secondNumber += operation[secondIndex]
                    if (secondIndex == operation.length - 1) {
                        break
                    } else
                        secondIndex++
                }
                tmpResult = (firstNumber.toFloat() + secondNumber.toFloat()).toString()
                operation = operation.replace(firstNumber + "+" + secondNumber, tmpResult)
        }
        //Odejmowanie
        while(operation.contains("-")){
            //dodane ze względu na możliwośc pojawienia sie liczb ujemnych
            numeric = operation.matches("-?\\d+(\\.\\d+)?".toRegex())
            if (numeric){
                break
            }
            index = operation.indexOf('-')
            firstIndex = index - 1
            secondIndex = index + 1
            firstNumber = ""
            secondNumber = ""
            while ((operation[firstIndex] != '+') and (operation[firstIndex] != '-') and (operation[firstIndex] != '/') and (operation[firstIndex] != '*')) {
                firstNumber = operation[firstIndex] + firstNumber
                if (firstIndex == 0) {
                    break
                } else
                    firstIndex--
            }
            while ((operation[secondIndex] != '+') and (operation[secondIndex] != '-') and (operation[secondIndex] != '/') and (operation[secondIndex] != '*')) {
                secondNumber += operation[secondIndex]
                if (secondIndex == operation.length - 1) {
                    break
                } else
                    secondIndex++
            }
            tmpResult = (firstNumber.toFloat() - secondNumber.toFloat()).toString()
            operation = operation.replace(firstNumber + "-" + secondNumber, tmpResult)
        }

        result = operation
        return result;
    }
}