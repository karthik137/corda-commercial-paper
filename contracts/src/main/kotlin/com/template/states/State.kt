package com.template.states

import com.template.contracts.CommercialPaper
import net.corda.core.contracts.*
import net.corda.core.crypto.NullKeys
import net.corda.core.identity.AbstractParty
import net.corda.core.identity.AnonymousParty
import java.time.Instant
import java.util.*

// *********
// * State *
// *********
@BelongsToContract(CommercialPaper::class)
data class State(val issuance: PartyAndReference,
                 val faceValue: Amount<Issued<Currency>>,
                 val maturityDate: Instant,
                 override val owner: AbstractParty) : OwnableState {
    override val participants: List<AbstractParty>
        get() {
            return participants
        }


    fun withoutOwner() = copy(owner = AnonymousParty(NullKeys.NullPublicKey))

    override fun withNewOwner(newOwner: AbstractParty): CommandAndState {
     TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //return CommandAndState()
        return CommandAndState(CommercialPaper.Commands.Move(),copy(issuance, faceValue, maturityDate, owner = newOwner))
    }
}
