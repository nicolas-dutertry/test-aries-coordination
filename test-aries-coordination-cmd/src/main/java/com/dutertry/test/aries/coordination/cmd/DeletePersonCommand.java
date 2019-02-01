package com.dutertry.test.aries.coordination.cmd;

import com.dutertry.test.aries.coordination.service.TestService;
import org.apache.karaf.shell.api.action.Action;
import org.apache.karaf.shell.api.action.Argument;
import org.apache.karaf.shell.api.action.Command;
import org.apache.karaf.shell.api.action.lifecycle.Reference;
import org.apache.karaf.shell.api.action.lifecycle.Service;
import java.util.List;

/**
 *
 * @author ndutertry
 */
@Command(scope = "person", name = "delete", description = "Delete a person")
@Service
public class DeletePersonCommand implements Action {

    @Argument(index = 0, name = "lastName", description = "Last name", required = true, multiValued = true)
    private List<String> lastNames;
    
    @Reference
    private TestService testService;

    @Override
    public Object execute() throws Exception {
        testService.delete(lastNames.toArray(new String[lastNames.size()]));
        
        return null;
    }

}
