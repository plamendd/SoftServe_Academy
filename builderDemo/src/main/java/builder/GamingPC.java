package builder;

public class GamingPC extends Computer {
    private String keyboard;
    private String mouse;

    public GamingPC(GamingPC.Builder builder){
        super(builder);
        this.keyboard = builder.keyboard;
        this.mouse = builder.mouse;
    }
    public static GamingPC.Builder builder() {
        return new GamingPC.Builder();
    }

    public static class Builder extends Computer.Builder<Builder> {
        private String keyboard;
        private String mouse;

        @Override
        public Builder getThis() {
            return this;
        }

        public Builder setKeyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public Builder setMouse(String mouse) {
            this.mouse = mouse;
            return this;
        }

        public GamingPC build() {
            return new GamingPC(this);
        }


    }

}
