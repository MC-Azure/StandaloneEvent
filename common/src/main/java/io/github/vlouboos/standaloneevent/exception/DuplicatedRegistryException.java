// This file is part of StandaloneEvent.
// You WON'T be guaranteed to be permitted with this file unless you're under BSD-3 License.
// See https://spdx.org/licenses/BSD-3-Clause.html
package io.github.vlouboos.standaloneevent.exception;

public class DuplicatedRegistryException extends RuntimeException {
    private final Object object;

    public DuplicatedRegistryException(Object object) {
        this.object = object;
    }

    @Override
    public String getLocalizedMessage() {
        return String.format("Duplicated Registry: %s%s", object, object.getClass().getSimpleName());
    }
}
