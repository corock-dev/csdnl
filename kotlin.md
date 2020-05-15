```kotlin
import java.util.Random
/**
 * You can edit, run, and share this code. 
 * play.kotlinlang.org 
 */
class Person(name: String, age: Int) {
    var random_age: Int = 25
    set(value) {
        var random = Random()
        
        field = value + random.nextInt(5)
    }
    get() {
        var random = Random()
        
        return field - random.nextInt(5)
    }
//     var name = name
//     var age = age
}

var name: String = "gil-dong"
var age: Int = 25

fun main() {
    var age_str = age.toString()
    
    var person1 = Person("gil-dong", 25)

    println("Hello, kotlin!!!")
    println(name)
    println("his age is $age_str")
//     person1.random_age = 20
    println(person1.random_age)
}
```