import java.util.Objects;

public class Comp {
    private String monitor = "LG";
    private String keyboard = "logitech keyboard";
    private String mouse = "logitech mouse";

    public Comp() {
    }

    public Comp(String monitor, String keyboard, String mouse) {
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comp comp = (Comp) o;
        return Objects.equals(monitor, comp.monitor) &&
                Objects.equals(keyboard, comp.keyboard) &&
                Objects.equals(mouse, comp.mouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monitor, keyboard, mouse);
    }

    @Override
    public String toString() {
        return "Comp{" +
                "monitor='" + monitor + '\'' +
                ", keyboard='" + keyboard + '\'' +
                ", mouse='" + mouse + '\'' +
                '}';
    }
}
