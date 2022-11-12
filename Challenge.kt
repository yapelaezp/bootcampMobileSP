const val TYPE_A = "tipoa"
const val TYPE_B = "tipob"
const val ASC = "asc"
const val DESC = "desc"

fun main(){
    var type: String
    do {
        println("Enter the type of string: TipoA  or TipoB")
        type = readln()
        if (!type.equals(TYPE_A, true) && !type.equals(TYPE_B, true)) println("Invalid input")
    } while (!type.equals(TYPE_A, true) && !type.equals(TYPE_B, true))

    val randomString = getRandomString(type.lowercase())
    println("The string generated was: $randomString")
    // Convert string to integer list
    val numberList = randomString.toList().map { it.toString().toInt() }

    var order: String
    do {
        println("Enter the order to sort the string: asc  or desc")
        order = readln()
        if (!order.equals(ASC, true) && !order.equals(DESC, true)) println("Invalid input")
    } while (!order.equals(ASC, true) && !order.equals(DESC, true))

    println(sortList(numberList as ArrayList<Int>, order.lowercase()))
}

fun getRandomString(type: String): String{
    //Generate a String with length 8 from 0 to 9
    val randomString: String = List(8) { ('0'..'9').random() }.joinToString("")
    return when (type) {
        TYPE_A -> "54$randomString"
        TYPE_B -> "08$randomString"
        else -> "Invalid type"
    }
}

fun sortList(numberList: ArrayList<Int>, order: String): ArrayList<Int> {
    var temp: Int
    for(i in 0 until numberList.size-1){
        for(j in (i+1) until numberList.size){
            when (order){
                ASC -> {
                    if (numberList[j] < numberList[i]){
                        temp = numberList[j]
                        numberList[j] = numberList[i]
                        numberList[i] = temp
                    }
                }
                DESC ->{
                    if (numberList[j] > numberList[i]){
                        temp = numberList[j]
                        numberList[j] = numberList[i]
                        numberList[i] = temp
                    }
                }
            }
        }
    }
    return numberList
}