package Question1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean flag = true;
        String command, commandContent = null, commandName;
        VirtualCommandPromp virtualCommandPromp = new VirtualCommandPromp();
        String path = virtualCommandPromp.getRoot().getData() + ":\\";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.print(path + ">");
            command = br.readLine();
            if (command.indexOf(" ") != -1) {
                commandName = command.substring(0, command.indexOf(" "));
                commandContent = command.substring(command.indexOf(" ") + 1);
            } else {
                commandName = command;
                commandContent = null;
            }
            switch (commandName.toLowerCase()) {
            case "mkdir":
                if (commandContent == null) {
                    System.out
                            .println("The syntax of the command is incorrect.");
                } else {
                    virtualCommandPromp.getCurrent().addChild(
                            new Node<String>(commandContent));
                }
                break;
            case "cd":
                if (commandContent == null) {
                    System.out
                            .println("The syntax of the command is incorrect.");
                } else if (virtualCommandPromp
                        .checkDirectoryExistsOrNot(commandContent)) {
                    virtualCommandPromp.setCurrent(virtualCommandPromp
                            .getCurrent().getChild(commandContent));
                    path = path + commandContent + "\\";
                } else {
                    System.out
                            .println("No such directory found.");
                }
                break;
            case "bk":
                if (commandContent == null) {
                    String data = virtualCommandPromp.getCurrent().getData();
                    Node<String> node = virtualCommandPromp.getCurrent()
                            .getParent();
                    virtualCommandPromp.setCurrent(node);
                    if (!(node == null)) {
                        path = path.substring(0, path.indexOf(data));
                    }
                } else {
                    System.out
                            .println("The syntax of the command is incorrect.");
                }
                break;
            case "ls":
                if (commandContent == null) {
                    virtualCommandPromp.show(virtualCommandPromp.getCurrent());
                } else {
                    System.out
                            .println("The syntax of the command is incorrect.");
                }
                break;
            case "find":
                if (commandContent == null) {
                    System.out
                            .println("The syntax of the command is incorrect.");
                } else {
                    System.out.println(virtualCommandPromp.find(
                            virtualCommandPromp.getCurrent().getChildrens(),
                            commandContent));
                }
                break;
            case "tree":
                if (commandContent == null) {
                    virtualCommandPromp.printTree(
                            virtualCommandPromp.getRoot(), " ");
                } else {
                    System.out
                            .println("The syntax of the command is incorrect.");
                }
                break;

            case "exit":
                if (commandContent == null) {
                    flag = false;
                } else {
                    System.out
                            .println("The syntax of the command is incorrect.");
                }
                break;

            default:
                System.out.println("command does not exist");
            }
        } while (flag);
    }
}
