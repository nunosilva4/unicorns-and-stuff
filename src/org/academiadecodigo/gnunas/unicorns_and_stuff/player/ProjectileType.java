package org.academiadecodigo.gnunas.unicorns_and_stuff.player;

public enum ProjectileType {

    BADDIE("resources/attacks/pixil-frame-0 (13).png"),
    FRIENDLY("resources/attacks/pixil-frame-0 (13).png");

    private String imagePath;

    ProjectileType(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

}
