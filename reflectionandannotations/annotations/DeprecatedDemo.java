package reflectionandannotations.annotations;


class LegacyAPI {

    @Deprecated
    public void oldFeature() {
        System.out.println("Old feature - Do not use this!");
    }

    public void newFeature() {
        System.out.println("New feature - Use this instead!");
    }
}

public class DeprecatedDemo {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();

        // Calling both methods
        api.oldFeature();   // Deprecated method (should show a warning)
        api.newFeature();   // New method
    }
}
