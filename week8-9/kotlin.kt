import java.util.Random
/**
 * You can edit, run, and share this code. 
 * play.kotlinlang.org 
 */
class Person(name: String, id: Int) {
    var random_id: Int = 25
    set(value) {
        var random = Random()
        
        field = value + random.nextInt(5)
    }
    get() {
        var random = Random()
        
        return field - random.nextInt(5)
    }
//     var name = name
//     var id = id
}

var name: String = "je-hoon"
var id: Int = 201824638

fun main() {
    var id_str = id.toString()
    
    var person1 = Person("je-hoon", 201824638)

    println("Hello, kotlin!!!")
    println(name)
    println("his id is $id_str")
//     person1.random_id = 20
    println(person1.random_id)
}