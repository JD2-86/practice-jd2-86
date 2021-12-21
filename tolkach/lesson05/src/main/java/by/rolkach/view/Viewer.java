package by.rolkach.view;

/**
 * Class for building html-code.
 */

public class Viewer {
    protected String getText(String[] userData) {
        return  "<p><b>ID</b> " + userData[0] + "</p>" +
                "<p><b>FirstName</b> " + userData[1] + " </p>" +
                "<p><b>LastName</b> " + userData[2] + "</p>" +
                "<p><b>UserName</b> " + userData[3] + "</p>" +
                "<p><b>Email</b> " + userData[5] + "</p>" +
                "<br><br>" +
                "<form action=\"/view/users\" method=\"GET\">\t\t\n" +
                "<input type=\"submit\" value=\"Back to table\" />\n" +
                "</form>";
    }

    protected String getTableHeader() {
        return "<table border=\"2\">\n" +
                "  <tr>\n" +
                "    <td>ID</td>\n" +
                "    <td>FirstName</td>\n" +
                "    <td>LastName</td>\n" +
                "    <td>UserName</td>\n" +
                "    <td>Email</td>\n" +
                "  </tr>\n";
    }
    protected String getTableBody(String[] userData) {
        return "  <tr>\n" +
                "    <td><a href=\"/view/users/" + userData[0] + "\">" + userData[0] + "</a></td>\n" +
                "    <td>" + userData[1] + "</td>  " +
                "    <td>" + userData[2] + "</td>  " +
                "    <td>" + userData[3] + "</td>  " +
                "    <td>" + userData[5] + "</td>  " +
                "</tr>\n";
    }
    protected String getTableFooter() {
        return "</table>" +
                "<br><br>" +
                "<form action=\"/view/command/create-user\" method=\"GET\">\t\t\n" +
                "<input type=\"submit\" value=\"Create user\" />\n" +
                "</form>";
    }
}
