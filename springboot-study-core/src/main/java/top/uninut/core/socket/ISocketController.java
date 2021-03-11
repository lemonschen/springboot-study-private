package top.uninut.core.socket;

/**
 * support create room, remove room, view room detail, create user, remove user
 */
public interface ISocketController {
    void createRoom();
    void removeRoom();
    Room roomDetail();
    void createUser();
    void removeUser();
}
