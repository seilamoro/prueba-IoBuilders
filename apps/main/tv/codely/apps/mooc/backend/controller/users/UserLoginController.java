package tv.codely.apps.mooc.backend.controller.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.users.application.UserResponse;
import tv.codely.mooc.users.application.find.FindUserQuery;
import tv.codely.mooc.users.domain.UserNotExist;
import tv.codely.shared.domain.DomainError;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.command.CommandHandlerExecutionError;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.infrastructure.spring.ApiController;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public class UserLoginController extends ApiController {
    public UserLoginController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @GetMapping(value = "/users/login")
    public ResponseEntity<HashMap<String, Serializable>> index(
        @RequestBody Request request
    ) throws CommandHandlerExecutionError {
        UserResponse user = ask(new FindUserQuery(request.id(), request.password()));

        return ResponseEntity.ok().body(new HashMap<String, Serializable>() {{
            put("id", user.id());
            put("name", user.name());
            put("surname", user.surname());
            put("mobile", user.mobile());
        }});
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return new HashMap<Class<? extends DomainError>, HttpStatus>() {{
            put(UserNotExist.class, HttpStatus.NOT_FOUND);
        }};
    }
}
