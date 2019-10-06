package com.template.contracts

import com.template.states.State
import net.corda.core.contracts.*
import net.corda.core.transactions.LedgerTransaction
import org.omg.CORBA.COMM_FAILURE

// ************
// * Contract *
// ************
class CommercialPaper : Contract {
    companion object {
        // Used to identify our contract when building a transaction.
        const val ID = "com.template.contracts.CommercialPaper"
    }

    // A transaction is valid if the verify() function of the contract of all the transaction's input and output states
    // does not throw an exception.
    override fun verify(tx: LedgerTransaction) {

        // Verification logic goes here.
        val groups = tx.groupStates(State::withoutOwner)

        val command = tx.commands.requireSingleCommand<CommercialPaper.Commands>()

        val timeWindow: TimeWindow? = tx.timeWindow

        for ((inputs, outputs) in groups){
            when(command.value){
                is Commands.Move -> {

                }

                is Commands.Redeem -> {

                }

                is Commands.Issue -> {

                }

                else -> throw IllegalArgumentException("Unrecognised command")
            }
        }
    }

    // Used to indicate the transaction's intent.
    interface Commands : CommandData {
        class Move : TypeOnlyCommandData(), Commands
        class Redeem : TypeOnlyCommandData(), Commands
        class Issue : TypeOnlyCommandData(), Commands
    }
}