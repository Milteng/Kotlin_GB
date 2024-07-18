package KotlinTasks.Seminar_2;

sealed class Command {
     abstract fun isValid():Boolean;
}