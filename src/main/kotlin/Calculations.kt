import tornadofx.Controller

class Calculations: Controller() {
    fun getResult(inputValue: String) : String {
        var result : String
        var i : Int
        result = "?"
        var match : Boolean;
        val tmpC : String
        val allSigns =
            arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "/", "*")
        val allNumber =
            arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
        val allOperators =
            arrayOf("+", "-", "/", "*")

        //Sprawdzanie czy wszsytkie znaki są poprawne
        for(c in inputValue) {
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
        if((inputValue.first() == '+') or (inputValue.first() == '-') or
                (inputValue.first() == '/') or (inputValue.first() == '*')){
            result = "Invalid first character"
            return result
        } else if((inputValue.last() == '+') or (inputValue.last() == '-') or
            (inputValue.last() == '/') or (inputValue.last() == '*')) {
            result = "Invalid last character"
            return result
        }

        //Sprawdzanie czy operatory nie występują obok siebie
        i = 0
        for(c in inputValue) {
            i++
            if ((c == '+') or (c == '-') or (c == '/') or (c == '*')) {
                if ((inputValue[i] == '+') or (inputValue[i] == '-') or (inputValue[i] == '/') or (inputValue[i] == '*')) {
                    result = "Incorrect operation"
                    return result
                }
            }
        }


        //Docelowe obliczenia
        //Mnozenie
        while(inputValue.contains("*")){

            }
        //Dzielenie
        while(inputValue.contains("/")){
            break
        }
        //Dodawanie
        while(inputValue.contains("+")){
            break
        }
        //Odejmowanie
        while(inputValue.contains("-")){
            break
        }









        return result;
    }
}