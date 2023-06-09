public class Phone {
    private final int osId;
    private final int clientDeviceYear;

    public Phone(int osId) {
        this.osId = osId;
        this.clientDeviceYear = 0;
    }

    public Phone(int osId, int clientDeviceYear) {
        this.osId = osId;
        this.clientDeviceYear = clientDeviceYear;
    }

    public String getDeviceOS() {
        switch (this.osId) {
            case 0:
                return "iOS";
            case 1:
                return "Android";
            default:
                return null;
        }
    }

    public int getDeviceYear() {
        return clientDeviceYear;
    }
}