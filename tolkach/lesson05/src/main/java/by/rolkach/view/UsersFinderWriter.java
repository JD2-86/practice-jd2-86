package by.rolkach.view;

import jakarta.servlet.http.HttpServletRequest;

import java.io.*;

/**
 * Class for writing and finding users in file.
 */

public class UsersFinderWriter {
    private static Integer userID = 10;

    protected void writeUser(String[] line, HttpServletRequest request) {
        WorkerWithFile file = new WorkerWithFile();

        try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter(file.getListOfUsers(request),true))) {
                writer.write(line[0] + ";" + line[1] + ";" + line[2] + ";" + line[3] +
                        ";" + line[4] + ";" + line[5] + ";");
                writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected String[] findUser(String id, HttpServletRequest request) {
        WorkerWithFile file = new WorkerWithFile();

        String[] list = new String[6];
        try (BufferedReader reader = new BufferedReader(
                new FileReader(file.getListOfUsers(request)))) {
            String result = reader.readLine();
            while (result != null) {
                list = result.split(";");
                if (list[0].equals(id)) {
                    return list;
                }
                result = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    protected static String getID() {
        userID++;
        return Integer.toString(userID);
    }
}
