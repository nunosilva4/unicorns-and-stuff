package org.academiadecodigo.gnunas.unicorns_and_stuff.player;

public enum ProjectileType {

    BADDIE("resources/attacks/pixil-frame-0 (13).png"),
    FRIENDLY("resources/attacks/pixil-frame-0 (13).png");

    private String image;

    ProjectileType(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

}
