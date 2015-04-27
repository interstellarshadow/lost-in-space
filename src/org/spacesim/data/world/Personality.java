package org.spacesim.data.world;

import java.util.Random;

public class Personality {
    /**
     * @param r random variable for consistent generation
     * @return a randomly generated personality.
     */
    public static Personality generatePersonalities(Random r) {
        Personality p = new Personality();
        p.setIntellectual(r.nextInt(SCALE));
        p.setCaring(r.nextInt(SCALE));
        p.setMilataristic(r.nextInt(SCALE));
        p.setGreed(r.nextInt(SCALE));
        p.setLawful(r.nextInt(SCALE));

        return p;
    }

    /**
     *
     * @param r random variable for consistent generation.
     * @param p parent personality for weighted generation.
     * @return a new randomly generated personality based off the parent.
     */
    public static Personality generatePersonalities(Random r, Personality p) {
        Personality p2 = new Personality();

        p2.setIntellectual((int) (((MODIFIER_SCALE * r.nextGaussian()) + 1) * p.getIntellectual()));
        p2.setCaring((int) (((MODIFIER_SCALE * r.nextGaussian()) + 1) * p.getCaring()));
        p2.setMilataristic((int) (((MODIFIER_SCALE * r.nextGaussian()) + 1) * p.getMilitaristic()));
        p2.setGreed((int) (((MODIFIER_SCALE * r.nextGaussian()) + 1) * p.getGreed()));
        p2.setLawful((int) (((MODIFIER_SCALE * r.nextGaussian()) + 1) * p.getLawful()));

        return p2;

    }

    public static final int SCALE = 999;
    public static final double MODIFIER_SCALE = .8;
    private int intellectual;
    private int lawful;
    private int milataristic;

    private int greed;

    private int caring;

    public int getCaring() {
        return caring;
    }

    public int getGreed() {
        return greed;
    }

    public int getIntellectual() {
        return intellectual;
    }

    public int getLawful() {
        return lawful;
    }

    public int getMilitaristic() {
        return milataristic;
    }

    public void setCaring(int caring) {
        this.caring = SCALE >= caring ? (0 <= caring ? caring : 0) : SCALE;

    }

    public void setGreed(int greed) {
        this.greed = SCALE >= greed ? (0 <= greed ? greed : 0) : SCALE;
    }

    public void setIntellectual(int intellectual) {
        this.intellectual = SCALE >= intellectual ? (0 <= intellectual ? intellectual : 0) : SCALE;
    }

    public void setLawful(int lawful) {
        this.lawful = SCALE >= lawful ? (0 <= lawful ? lawful : 0) : SCALE;
    }

    public void setMilataristic(int milataristic) {
        this.milataristic = SCALE >= milataristic ? (0 <= milataristic ? milataristic : 0) : SCALE;
    }

    @Override
    public String toString() {
        return "{ Intellectual: " + intellectual + ", Lawful: " + lawful + ", Milataristic: " + milataristic
                + ", Greed: " + greed + ", Caring: " + caring + " }";

    }

}
