package Api.ElOtroSeArruino.Mokito.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WeatherReportServiceTest {

    @Mock
    private WeatherRepository weatherRepository;

    @InjectMocks
    private WeatherReportService weatherReportService;

    private WeatherReport weatherReport;

    @BeforeEach
    void setUp() {
        weatherReport = new WeatherReport();
        weatherReport.setLocation("Paris");
        weatherReport.setTemperature(25);
    }

    @Test
    void testGetWeatherReport() {
        when(weatherRepository.findByLocation("Paris")).thenReturn(weatherReport);

        WeatherReport found = weatherReportService.getWeatherReport("Paris");

        assertNotNull(found);
        assertEquals("Paris", found.getLocation());
        assertEquals(25, found.getTemperature());
    }

    @Test
    void testSaveWeatherReport() {
        when(weatherRepository.save(any(WeatherReport.class))).thenReturn(weatherReport);

        WeatherReport saved = weatherReportService.saveWeatherReport(weatherReport);

        assertNotNull(saved);
        assertEquals("Paris", saved.getLocation());
        verify(weatherRepository, times(1)).save(weatherReport);
    }

    @Test
    void testDeleteWeatherReport() {
        doNothing().when(weatherRepository).deleteById(anyString());

        weatherReportService.deleteWeatherReport("Paris");

        verify(weatherRepository, times(1)).deleteById("Paris");
    }

    @Test
    void testUpdateWeatherReport() {
        when(weatherRepository.save(any(WeatherReport.class))).thenReturn(weatherReport);

        WeatherReport updated = weatherReportService.updateWeatherReport(weatherReport);

        assertNotNull(updated);
        assertEquals("Paris", updated.getLocation());
    }

    @Test
    void testGetAllWeatherReports() {
        when(weatherRepository.findAll()).thenReturn(List.of(weatherReport));

        List<WeatherReport> reports = weatherReportService.getAllWeatherReports();

        assertFalse(reports.isEmpty());
        assertEquals(1, reports.size());
    }
}
