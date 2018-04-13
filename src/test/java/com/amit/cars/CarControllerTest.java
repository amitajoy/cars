package com.amit.cars;

import com.amit.cars.model.Car;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.util.ArrayList;
import java.util.List;

import static com.amit.cars.CarsController.CARS_RESOURCE;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CarControllerTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    private CarService carService;

    @InjectMocks
    private CarsController carsController;

    //need to do this for the rest service testing
    private MockMvc mockMvc;

    private List<Car> cars = createCarsList();
    private static final String JSON_ERROR_FIELD = "$.errors[0].field";
    private static final String JSON_ERROR_CODE = "$.errors[0].code";
    private static final String JSON_ERROR_MESSAGE = "$.errors[0].message";
    private static final String JSON_ERROR_RECOVERABILITY = "$.errors[0].recoverability";
    private static final String RECOVERABLE = "Recoverable";
    private static final String ACTOR_ID_STRING = "actorId";
    private static final String UNABLE_TO_PARSE_ACTOR_ID = "unable-to-parse-actor-id";
    private static final String ACTOR_ID_IS_NOT_VALID = "actor id is not valid";

    private List<Car> createCarsList() {
        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car(1, "abc"));
        carsList.add(new Car(2, "def"));
        return carsList;
    }

    @Before
    public void before() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(carsController)
                // .setHandlerExceptionResolvers(createExceptionResolver())
                .build();

        doReturn(cars).when(carService).getCars();
        doReturn(cars.get(0)).when(carService).getCar(1);
    }

    @Test
    public void testGetCars() throws Exception {
        mockMvc.perform(get(CARS_RESOURCE))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"carId\":1,\"name\":\"abc\"},{\"carId\":2,\"name\":\"def\"}]"));

        verify(carService, times(1)).getCars();
    }

    private ExceptionHandlerExceptionResolver createExceptionResolver() {
//        ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver() {
//            @Override
//            protected ServletInvocableHandlerMethod getExceptionHandlerMethod(HandlerMethod handlerMethod, Exception exception) {
//                Method method = new ExceptionHandlerMethodResolver(InvValidationErrorHandler.class).resolveMethod(exception);
//                return new ServletInvocableHandlerMethod(new InvValidationErrorHandler(), method);
//            }
//        };
//        exceptionResolver.setReturnValueHandlers(Arrays.asList(new RequestResponseBodyMethodProcessor(Arrays.asList(createMessageConverter()))));
//        exceptionResolver.afterPropertiesSet();
//        return exceptionResolver;
        return null;
    }

//    @Test
//    public void testcarsWithJsonResponse() throws Exception {
//        String invalidActorId = "12avdj";
//
//        mockMvc.perform(get(STATEMENTS_END_POINT + MONTHLY, invalidActorId).accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().is4xxClientError())
//                .andExpect(jsonPath(JSON_ERROR_FIELD, is(ACTOR_ID_STRING)))
//                .andExpect(jsonPath(JSON_ERROR_CODE, is(UNABLE_TO_PARSE_ACTOR_ID)))
//                .andExpect(jsonPath(JSON_ERROR_MESSAGE, is(ACTOR_ID_IS_NOT_VALID)))
//                .andExpect(jsonPath(JSON_ERROR_RECOVERABILITY, is(RECOVERABLE)));
//    }
}
