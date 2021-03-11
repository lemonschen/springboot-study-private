package top.uninut.core.socket;

public class SocketController implements ISocketController{

    private SocketBusServer busServer;

    public static void main(String[] args) {
        SocketController controller = new SocketController();
        controller.busServer = SocketBusServer.getSocketBusServer();
//        PrintHelper.printHomePage();
    }

    @Override
    public void createRoom() {

    }

    @Override
    public void removeRoom() {

    }

    @Override
    public Room roomDetail() {
        return null;
    }

    @Override
    public void createUser() {

    }

    @Override
    public void removeUser() {

    }
}
