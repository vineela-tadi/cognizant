public class Main {
    public static void main(String[] args) {

        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        // Turn ON
        remote.setCommand(lightOn);
        remote.pressButton();

        // Turn OFF
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}