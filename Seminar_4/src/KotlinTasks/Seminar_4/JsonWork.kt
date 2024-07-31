package KotlinTasks.Seminar_4

class JsonWork (val obj: MutableMap<String, Any>) {
    operator fun set(key: String, value: Any) {
        obj[key] = value;
    }

    override fun toString(): String {
        return obj.toString()
    }
}

fun json(init: JsonWork.() -> Unit): String {
    val obj = JsonWork(mutableMapOf())
    obj.init()
    return obj.toString()
}