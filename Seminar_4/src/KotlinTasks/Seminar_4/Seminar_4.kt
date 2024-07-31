package KotlinTasks.Seminar_4


import KotlinTasks.Seminar_2.*;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.UIManager.put;

class Seminar_4 {

    val listPerson:MutableList<Person> = mutableListOf();

    var person: Person = Person("", "", "");

    fun findPerson(aName : String):Person?{
        for (a in listPerson){
            if (a.name == aName) return a;
        }

        return null;
    }


    fun find(aValue:String):Unit{
        //проверим по какому атрибуту ищем
        var i:Int = 0;

        val is_phone = aValue.matches(Regex("""^\+?\d+[\d-]*${'$'}"""));
        val is_email = aValue.matches(Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"));

        if ( !is_phone && !is_email) {
            println("Неверный формат значения поиска");
            return;
        }

        //телефон
        for (a in listPerson){
            if  (is_phone){
                for (b in a.listPhone){
                    if (b == aValue) {
                        println(a.name);
                        i++;
                    }
                }

            }
            else {
                for (b in a.listEmails) {
                    if (b == aValue) {
                        println(a.name);
                        i++;
                    }
                }

            }

        }
        if (i == 0) println("Совпадений не найдено");

    }

    fun <T : MutableList<String>> outListElement(e : T){
        for (a in e) {
            println("   -> $a");
        }
    }


    fun readCommand(input: String): Command?{
        var t_arr = input.split(" ");

        if (t_arr.size<2) {
            println("Неизвестная команда");
            return null;
        }

        if (t_arr[0] == "show") {
            if (t_arr.size == 2) {
                val p:Person? = findPerson(t_arr[1]);
                if  (p != null) {
                    println("Выводим Email:");
                    outListElement(p.listEmails);

                    println("Выводим телефоны:");
                    outListElement(p.listPhone);

                }
                else
                    println("Совпадений не найдено");
                return ShowCommand(null);
            }
            else
                return null;
        }

        if (t_arr[0] == "find") {
            if (t_arr.size == 2) {
                find(t_arr[1]);
                return ShowCommand(null);
            }
            else
                return null;
        }

        if (t_arr[0] == "export") {
           var path:String = "";
           for (i in 1..t_arr.size-1) {
               path = path + t_arr[i];
           }

            val json = """
                [
                    ${listPerson.joinToString(",\n") { "{\"\"name\"\": \"\"${it.name}\"\", \"\"phones\"\": [${it.getListString(it.listPhone)}], \"\"emails\"\": [${it.getListString(it.listEmails)}]}" }}
                ]
           """.trimIndent()

           File(path).writeText(json)
           println("    Экпорт выполнен успешно. Смотри файл $path.")
           return ShowCommand(null);
        }





        if (t_arr.size !=4) {
            return null
        } else {
            //не нужно тут нам вводить непонятно что...а то удумали понимаешь....
            if (t_arr[0] != "add") {
                return null;
            }

            //ну по крайней мере ввели 4 строковых литерала
            if (t_arr[2] == "phone") {
                var p:Person? = null;
                p = findPerson(t_arr[1]);

                if (p==null) {
                    p = Person(t_arr[1], t_arr[3], "");
                    listPerson.add(p);
                }
                else
                    p.addPhone(t_arr[3])

                return CommandAddPhone(p);

            }
            else
                if (t_arr[2] == "email") {
                    var p:Person? = null;
                    p = findPerson(t_arr[1]);

                    if (p==null) {
                        p = Person(t_arr[1], "", t_arr[3]);
                        listPerson.add(p);
                    }
                    else
                        p.addEmail(t_arr[3]);

                    return CommandAddEmail(p);
                }
                else
                    return null;

        }

    }

    fun run(){
        println("Четвертый семинар!");

        val helpString = "Введите одну из следующих команд команд:\n" +
                "1. exit\n" +
                "2. help\n" +
                "3. show <Имя>\n" +
                "4. add <Имя> phone <Номер телефона>\n" +
                "5. add <Имя> email <Адрес электронной почты>\n"+
                "6. find <Телефон или Email>\n"+
                "7. export <file path>";

        println(helpString);

        while (true) {
            println("Введите команду");
            println("");
            val command = readLine() ?: continue;

            when (command){
                "exit" -> break;
                "help" -> println(helpString);
                else ->{
                    val cmd:Command? = readCommand(command);
                    if (cmd == null) {
                        println("Вы ввели неверную команду $command");
                    }
                    else {
                        if ( !cmd.isValid()) {
                            println("Команда не валидна!\n" +helpString);
                        }

                    }


                }
            }

        }

    }
}