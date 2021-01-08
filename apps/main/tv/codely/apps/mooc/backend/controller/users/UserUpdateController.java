package tv.codely.apps.mooc.backend.controller.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.users.application.update.UpdateUserCommand;
import tv.codely.shared.domain.DomainError;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.command.CommandHandlerExecutionError;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.infrastructure.spring.ApiController;

import java.util.HashMap;

@RestController
public class UserUpdateController extends ApiController {
    public UserUpdateController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/users/")
    public ResponseEntity<String> index(
        @RequestBody Request request
    ) throws CommandHandlerExecutionError {
        dispatch(new UpdateUserCommand(request.id(), request.name(), request.surname(), request.mobile(), request.password()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
