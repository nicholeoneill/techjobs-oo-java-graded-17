package org.launchcode.techjobs.oo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here
    //test the empty constructor
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String msg = "The Job class constructor correctly sets all of the fields";

        assertEquals(msg, "Product tester", job.getName());
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        Job job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));

        assertFalse(job1.getId() == job2.getId());
    }

    //When passed a Job object, it should return a string that contains a blank line before and after the job information.
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Ice cream tester", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));

        String newLine = System.lineSeparator();
        String entryStr = Job.toString(job);

        assertTrue(entryStr.startsWith(newLine) && entryStr.endsWith(newLine));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Ice cream tester", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));

        String msg = "toString() returns a string with a label for each field, followed by the data stored in that field. Each field is on its own line.";

        String newLine = System.lineSeparator();

        String expected = newLine + "ID: " + job.getId() + newLine + "Name: " + job.getName() + newLine + "Employer: " + job.getEmployer() + newLine + "Location: " + job.getLocation() + "Position Type: " + job.getPositionType() + newLine + "Core Competency: " + job.getCoreCompetency() + newLine;

        String actual = Job.toString(job);

        assertEquals(msg, expected, actual);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Ice cream tester", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency());

        String msg = "toString() returns 'Data not available' after label if the field is empty.";

        String newLine = System.lineSeparator();

        String expected = newLine + "ID: " + job.getId() + newLine + "Name: " + job.getName() + newLine + "Employer: " + job.getEmployer() + newLine + "Location: " + job.getLocation() + "Position Type: " + job.getPositionType() + newLine + "Core Competency: " + job.getCoreCompetency() + newLine;

        String actual = Job.toString(job);

        assertEquals(msg, expected, actual);
    }
}
