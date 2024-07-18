package KotlinTasks.Seminar_2

class ShowCommand(val person: Person?): Command() {
    override fun isValid(): Boolean {
        return true
    }
}