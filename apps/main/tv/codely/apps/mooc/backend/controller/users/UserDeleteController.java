package tv.codely.apps.mooc.backend.controller.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.users.application.delete.DeleteUserCommand;
import tv.codely.shared.domain.DomainError;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.command.CommandHandlerExecutionError;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.infrastructure.spring.ApiController;

import java.util.HashMap;

@RestController
public class UserDeleteController extends ApiController {
    public UserDeleteController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<String> index(
        @PathVariable String id
    ) throws CommandHandlerExecutionError {
        dispatch(new DeleteUserCommand(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}
