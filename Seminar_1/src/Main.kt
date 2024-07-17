//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val helpString = "Введите одну из следующих команд команд:\n" +
            "1. exit\n" +
            "2. help\n" +
            "3. add <Имя> phone <Номер телефона>\n" +
            "4. add <Имя> email <Адрес электронной почты>\n ";

    println(helpString);

    while (true) {
        print("Введите команду: ");
        val command = readLine() ?: continue;
        if (command == "exit") break;

        if (command == "help") {
            println(helpString);
        }
        else
        if (command.startsWith("add ")){
            var arrParams = command.split(" ");
            if (arrParams.size !=4) {
                println("Введена неверная команда $command");
            } else {
                //ну по крайней мере ввели 4 строковых литерала
                if (arrParams[2] == "phone") {
                    println("Добавлен ${arrParams[1]} с номером телефона ${arrParams[3]}");
                }
                else
                if (arrParams[2] == "phone") {
                        println("Добавлен ${arrParams[1]} с адресом электронной почты ${arrParams[3]}");
                }
                else
                    println("Введена неверная команда $command");

            }

        }
        else
            println("Введена неверная команда $command");


    }

}