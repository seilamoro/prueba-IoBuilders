package tv.codely.apps.mooc.backend.controller.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.users.application.create.CreateUserCommand;
import tv.codely.shared.domain.DomainError;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.command.CommandHandlerExecutionError;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.infrastructure.spring.ApiController;

import java.util.HashMap;

@RestController
public final class UserPostController extends ApiController {
    public UserPostController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<String> index(
        @RequestBody Request request
    ) throws CommandHandlerExecutionError {
        dispatch(new CreateUserCommand(request.id(), request.name(), request.surname(), request.mobile(), request.password()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}

