package common;

import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.collections.Lists;

import java.util.List;

import static common.BaseClass.applyLog;
import static java.lang.System.exit;

public class CustomAssertion extends Assertion {

    private List<String> assert_messages = Lists.newArrayList();

    @Override
    public void onBeforeAssert(IAssert a) {
    }

    @Override
    public void onAfterAssert(IAssert a) {
    }

    @Override
    public void onAssertSuccess(IAssert<?> assertCommand) {
//        assert_messages.add("OnlyOnAssertSuccess:" + assertCommand.getMessage());
        applyLog(getClass().toString(), assertCommand.getMessage()+" - PASSED");

    }

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
//        assert_messages.add("OnlyOnAssertFailure:" + ex.getLocalizedMessage());
        applyLog(getClass().toString(), ex.getLocalizedMessage()+" - FAILED");
    }

    public List<String> getAssertMessages() {
        return assert_messages;
    }
}