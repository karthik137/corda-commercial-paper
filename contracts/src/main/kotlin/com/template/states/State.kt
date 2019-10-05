package com.template.states

import com.template.contracts.TemplateContract
import net.corda.core.contracts.*
import net.corda.core.identity.AbstractParty
import java.time.Instant
import java.util.*

// *********
// * State *
// *********
//@BelongsToContract(TemplateContract::class)
//data class State(val data: String, override val participants: List<AbstractParty> = listOf()) : ContractState

data class State(val issuance: PartyAndReference,
                 val faceValue: Amount<Issued<Currency>>,
                 val maturityDate: Instant,
                 override val owner: AbstractParty) : OwnableState {
    override val participants: List<AbstractParty>
        get() {
            return participants
        }

    override fun withNewOwner(newOwner: AbstractParty): CommandAndState {
     TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //return CommandAndState()

    }
}
