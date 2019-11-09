package rpg_tests_exercise.p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AlarmTest {
    private Sensor sensor;
    private Alarm alarm;

    @Before
    public void initSensorAndAlarm() {
        this.sensor = Mockito.mock(Sensor.class);
        this.alarm = new Alarm(this.sensor);
    }

    @Test
    public void getAlarmMethodShouldReturnFalseIfLowPressureIsInBounds() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.0);
        this.alarm.check();
        Assert.assertFalse(this.alarm.getAlarmOn());
    }

    @Test
    public void getAlarmMethodShouldReturnFalseIfHighPressureIsInBounds() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.0);
        this.alarm.check();
        Assert.assertFalse(this.alarm.getAlarmOn());
    }

    @Test
    public void getAlarmMethodShouldReturnTrueIfLowPressureIsNotInBounds() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(15.0);
        this.alarm.check();
        Assert.assertTrue(this.alarm.getAlarmOn());
    }

    @Test
    public void getAlarmMethodShouldReturnTrueIfHighPressureIsNotInBounds() {
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(22.0);
        this.alarm.check();
        Assert.assertTrue(this.alarm.getAlarmOn());
    }

}