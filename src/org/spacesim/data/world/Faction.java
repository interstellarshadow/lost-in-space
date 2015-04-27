package org.spacesim.data.world;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.spacesim.data.people.IPerson;
import org.spacesim.data.ships.Ship;

/**
 * This is the class describing a faction in the world. It will have code for
 * the procedural generation of itself, as well as containing all of its
 * attributes, including wealth, tech levels, behavioral traits, and more.
 *
 * @author Andrew Schade
 */
public class Faction {
    /**
     * Generates a new random faction, with technologies and a fleet. This uses
     * a predefined random variable to allow for the use of a set random when
     * generating stuff. It will pass it through to generated items. This should
     * allow for the use of a seed to generate factions in a consistent way
     * (i.e. if you generate a faction using the same seed twice, it should
     * create identical results).
     *
     * @param r a random variable, so that you can save seeds.
     * @return the faction.
     */
    public static Faction generateFaction(Random r) {
        Faction faction = new Faction(r.nextInt(5000) + 1, r.nextInt(5000), Personality.generatePersonalities(r));
        faction.researchTechs(r);
        faction.generateFleet(r);
        return faction;
    }

    private int techLevel;
    private int wealthLevel;

    private Personality personality;

    /**
     * This is the constructor for factions, to be used by mods, the automated
     * faction generator, and UI. It just sets values for the personality, tech
     * points, and wealth level. This means that a user will have to research
     *
     * @param techlevel
     * @param wealthlevel
     * @param personality
     */
    public Faction(int techlevel, int wealthlevel, Personality personality) {
        this.personality = personality;
        this.techLevel = techlevel;
        this.wealthLevel = wealthlevel;
    }

    private boolean canResearchTechs(int techPoints) {
        // TODO Auto-generated method stub
        return techPoints == 0;
    }

    private List<Technology> researchabletechs(int techPoints) {
        return null;
        // TODO Auto-generated method stub
    }

    public Map<Integer, Ship> generateFleet(Random r) {
        return null;
        // TODO Auto-generated method stub

    }

    public IPerson generatePerson(int age, Random r) {
        IPerson p = null;
        return p;
    }

    public void researchTechs(Random r) {
        int pSum = personality.getCaring() + personality.getGreed() + personality.getIntellectual()
                + personality.getLawful() + personality.getMilitaristic();
        int caringTechPoints = (int) (personality.getCaring() / ((float) pSum) * techLevel);
        int lawfulTechPoints = (int) (personality.getLawful() / ((float) pSum) * techLevel);
        int militaristicTechPoints = (int) (personality.getMilitaristic() / ((float) pSum) * techLevel);
        int greedTechPoints = (int) (personality.getGreed() / ((float) pSum) * techLevel);
        int intellectualTechPoints = (int) (personality.getIntellectual() / ((float) pSum) * techLevel);
        while (canResearchTechs(caringTechPoints + lawfulTechPoints + greedTechPoints + militaristicTechPoints
                + intellectualTechPoints)) {
            //TODO implement
        }
    }

    public String toString() {
        return "{ TechPoints: " + techLevel + " Personality: " + personality.toString() + "}";
    }
}
