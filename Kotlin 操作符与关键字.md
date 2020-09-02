

1. `?`可空类型:表示这个对象可能为空
```kotlin
var str:String ?= "字符"
```
2. `?.`安全调用符
```kotlin
var str: String? = null
// var str: String? = "字符"
val len = str?.length // 如果str不为空,则返回str.length 如果str为null,则返回null
println(len)
```
3. `?:`Elvis 操作符
```kotlin
var str: String? = null
// 如果str?.length为null,那最后len=-100
// 如果str?.length不为null,那最后len=str?.length
val len = str?.length ?: -100 
// len1永远都为-100
val len1 = null ?: -100
```
4. `!!`操作符
```kotlin
var str: String? = null
val len = str!!.length // !! 表示肯定不为空
println(len)
```
5. `==`比较值
6. `===`比较内存地址值
7. `..`表示区间
8. `in`表示范围
9. `!in`表示不在范围内
10. downTo 倒序遍历
```kotlin
for (i: Int in 3 downTo 1) {
    println(i) // 3.2.1
}
```

11. step 步长
```kotlin
for (i in 1..5 step 2) {
    println(i) // 1.3.5
}
```
12. `_`
```kotlin
val person = Person("小明",18)
// _ 忽略作用
var (name,_) = person//解构
println(name)
data class Person(var name: String, var age: Int)
```
13. `::`
```kotlin
// 得到类的Class对象
startActivity(Intent(this@MainActivity, StartActivity::class.java))
```
14. `@` 符号
```kotlin
// 限定this的类型
class User {
    inner class Vip {
        fun getUser(): User {
            return this@User
        }
        fun getState(): Vip {
            return this@Vip
        }
    }
}
```
15. `$`符号

```kotlin
val m = 13
var str = "现在 $m 点"
println(str)
var str1 = "现在 ${m*3} 点"
println(str1)
```
16. `""" XXX """`符号

```kotlin
val str = """保留
    |原始格式
    |字符串""".trimMargin()
println(str)
```